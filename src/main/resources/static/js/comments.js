$(document).ready(function(){
    // Event listener to redirect to new page when .commentsButton clicked
    $(".commentsButton").on('click', function(e){
        window.location.replace(`/comments/${$(this).attr("data-id")}/create`);
    });
});