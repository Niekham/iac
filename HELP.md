# Getting Started

### Guides
The following guides illustrates how to use certain features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)

Voor het instellen van de database:
Maak eerst een nieuwe connectie in oracle sql developer.
Om deze te koppelen aan ons project:
1. Ga naar edit configurations (druk recht boven op WebshopApplication, waar je het project runt)
2. Open environment en klik op environmental variables en voer de volgende gegevens in:
   NAME      VALUE
 - DB_URL    .....
 - DB_USER   .....
 - DB_PASS   .....
3. Druk op ok en run de applicatie

Voor een goed werkende applicatie moeten het volgende worden uitgevoerd:


-- Trigger voor het verwerken van aanbiedingsprijs op basis van toevoegen/verwijderen van aanbieding aan product. 
create or replace trigger product_aanbieding
before insert or update of aanbieding_id
on product
for each row
declare
v_percentage number;
BEGIN
if(:new.aanbieding_id is not null)then
    select a.percentage into v_percentage from aanbieding a where a.id = :new.aanbieding_id;
    :new.aanbiedingprijs := :old.prijs / 100 * (100 - v_percentage);
    else 
    :new.aanbiedingprijs := null;
end if;
exception when no_data_found then :new.aanbiedingprijs := null;
end;


-- Trigger voor het toevoegen van product aan categorie “Nieuw” (in dit geval met id 2) wanneer een nieuw product is toegevoegd. 
create or replace trigger new_product
after insert on product
declare
new_id number;
begin
select product_seq.currval into new_id from dual;
insert into categorie_product values (2, new_id);
end;

-- Trigger voor instellen van openDatum wanneer account is aangemaakt.
create or replace trigger account_open
before insert on account
for each row
begin
:new.OPEN_DATUM := sysdate;
end;


-- Trigger voor verwijderen van aanbieding bij product wanneer een aanbieding wordt verwijderd
create or replace trigger delete_aanbieding
before delete on aanbieding
for each row
begin
   update product set aanbieding_id = null where aanbieding_id = :OLD.ID;
end;

-- scheduler en job voor automatisch verwijderen van aanbieding wanneer deze niet meer geldig is
BEGIN
    DBMS_SCHEDULER.CREATE_SCHEDULE (

        repeat_interval  => 'FREQ=DAILY;BYDAY=MON,TUE,WED,THU,FRI,SAT,SUN;BYHOUR=23;BYMINUTE=59;BYSECOND=59',
     
        schedule_name  => '"AANBIEDING_SCHEDULE"');
        
        DBMS_SCHEDULER.CREATE_JOB (
            job_name => '"IACWEBSHOP"."DELETE_AANBIEDING_ONSCHEDULE"',
            schedule_name => '"IACWEBSHOP"."AANBIEDING_SCHEDULE"',
            job_type => 'PLSQL_BLOCK',
            job_action => 'delete from AANBIEDING where TOT_DATUM <= sysdate;
commit;',
            number_of_arguments => 0,
            enabled => FALSE,
            auto_drop => FALSE,
               
            comments => '');

         
     
 
    DBMS_SCHEDULER.SET_ATTRIBUTE( 
             name => '"IACWEBSHOP"."DELETE_AANBIEDING_ONSCHEDULE"', 
             attribute => 'logging_level', value => DBMS_SCHEDULER.LOGGING_OFF);
      
  
    
    DBMS_SCHEDULER.enable(
             name => '"IACWEBSHOP"."DELETE_AANBIEDING_ONSCHEDULE"');

END;