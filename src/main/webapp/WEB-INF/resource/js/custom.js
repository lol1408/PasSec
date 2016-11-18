/**
 * Created by sergey on 24.10.16.
 */
$(function() {

    $("#js-register-form").validate({

        rules:{

            form_login:{
                required: true
            },form_email:{
                required: true,
                email: true
            },form_pswd1:{
                required: true,
                minlength:6
            },form_pswd2:{
                required: true,
                equalTo: "#form-pswd1"
            }
        }
    });

});
//submit press
jQuery(document).ready(function ($) {
    $("#js-register-form").submit(function (event) {
            event.preventDefault();
        postQuery();
    });
});
function postQuery() {
    var formData = {}
            formData["login"] = $("#form_login").val();
            formData["password"] = sha1($("#form-pswd1").val());
            formData["mail"] = $("#form_email").val();
    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/registration",
        data : JSON.stringify(formData),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            display(data);
        },
        error : function(e) {
          //  console.log("ERROR: ", e);
            display(e);
        },
        done : function(e) {
            console.log("DONE");
        }
    });
   /* function enableSearchButton(flag) {
        $("#btn-add").prop("disabled", flag);
    }*/
    }
function display(data) {
    var json = "<h4>Ajax Response</h4><pre>" +JSON.stringify(data, null, 4) +"</pre>";
    $('#feedback').html(json);
}