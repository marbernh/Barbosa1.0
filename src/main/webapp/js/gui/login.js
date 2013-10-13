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
        createLoginDialog().dialog("open");
    });
    
    $("#register")
            .button()
            .click(function() {
        createRegisterDialog().dialog("open");
    });

    function createLoginDialog() {
        $("#dialog-form").dialog({
            autoOpen: false,
            modal: true,
            stack: true,
            buttons: {
                Register: function() {
                    var def = register.newInstance("quiz_pu").login(getFormDialogData());
                    def.done(function() {
                        alert("User added!");
                    });
                    def.fail(function() {
                        alert("Failure!!");
                    })
                    $(this).dialog("close");
                },
                Cancel: function() {
                    $(this).dialog("close");
                }
            }
        });
        return $('#dialog-form');
    }
    
        function createRegisterDialog() {
        $("#dialog-form").dialog({
            autoOpen: false,
            modal: true,
            stack: true,
            buttons: {
                Register: function() {
                    var def = shop.getProductCatalogue().add(getFormDialogData());
                    def.done(function() {
                        alert("Product added!");
                    });
                    def.fail(function() {
                        alert("Failure!!");
                    });
                    $(this).dialog("close");
                },
                Cancel: function() {
                    $(this).dialog("close");
                }
            }
        });
        return $('#dialog-form');
    }

    function createErrorDialog(message) {
        // Using JQueryUI dialog
        $("#dialog-message").dialog({
            autoOpen: false,
            modal: true,
            stack: true,
            buttons: {
                Ok: function() {
                    $(this).dialog("close");
                },
                Cancel: function() {
                    $(this).dialog("close");
                }
            }
        });
        $('#dialog-message').dialog('option', 'title', 'Something went! wrong');
        $("#dialog-message #msg").text(message);
        return $('#dialog-message');
    }

    function getFormDialogData() {
        var user = {};
        user.userName = $("#dialog-form #username").val();
        user.password = $("#dialog-form #password").val();
        return user;
    }
});