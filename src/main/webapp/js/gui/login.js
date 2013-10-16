/*
 * All js for the products.html page 
 * 
 * NOTE: Last in file a comment to enable debugging
 * because this is dynamically loaded (doesn't work by default to debug
 * dynamic scripts in Chrome at least...)
 * 
 */
// Run after DOM constructed (same as $(document).ready())
$(function() {
    $("#login")
            .button()
            .click(function() {
        quiz.getRegister().login(getFormData());
    });
    
    $("#register")
            .button()
            .click(function() {
        quiz.getRegister().add(getFormData());
    });
    
    function getFormData() {
        var user = {};
        user.userName = $("#login-form #username").val();
        user.password = $("#login-form #password").val();
        return user;
    }
});