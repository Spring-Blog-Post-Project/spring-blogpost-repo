$(function() {
    console.log("Inside global.js");
    $(window).ready( function() {
        $(".focus-field").focus();
    });
});