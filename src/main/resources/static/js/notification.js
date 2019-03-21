$(document).ready(function(){
    jQuery('.toast__close').click(function(e){
        e.preventDefault();
        let parent = $(this).parent('.toast');
        parent.fadeOut("slow", function() { $(this).remove(); } );
    });
});