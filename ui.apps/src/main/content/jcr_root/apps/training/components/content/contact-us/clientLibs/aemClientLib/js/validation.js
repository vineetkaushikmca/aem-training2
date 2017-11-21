/* This validator is used to enable and disable mobile-message and time field according to mobile Number in Mobile Tab */
$.validator.register({
    selector: "form [data-validation='cq-dialog-thankyou']",
    clear: function(thankyouurl) {
        var emailAddress = $("form [data-validation='cq-dialog-emailaddress']");
        if (thankyouurl.val() !== "") {
emailAddress.attr('disabled', false);
        } else {
emailAddress.attr('disabled', true);
        }
    }
});


$(document).on("foundation-contentloaded", function(e) {

    /* call mobile tab validators on content loaded in Need Help Component*/
    $("form [data-validation='cq-dialog-thankyou']").updateErrorUI();

});