$(document).ready(function(){
    $(".deleteButton").on('click', function(e){
        window.location.replace(`/posts/${$(this).attr("data-id")}/delete`);
    });
});