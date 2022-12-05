$(document).ready(function(){
    $(".commentsButton").on('click', function(e){
        window.location.replace(`/comments/${$(this).attr("data-id")}/create`);
    });
});