$(document).ready(function(){
    console.log("inside delete.js");
    $(".deleteButton").on('click', function(e){
        console.log("Delete button pressed");
        window.location.replace(`/posts/${$(this).attr("data-id")}/delete`);
    });
});