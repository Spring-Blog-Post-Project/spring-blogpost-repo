$(document).ready(function(){
    $(".commentsButton").on('click', function(e){
        window.location.replace(`/posts/${$(this).attr("data-id")}/comments`);
    });
});