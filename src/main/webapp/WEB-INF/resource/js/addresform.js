$(document).ready(function () {
    $("#popup_form").validate({
        ignore: ":hidden",
        rules:{
            name_resource:{
                required:true
            },login_resource:{
                required:true
            },password_resource:{
                required:true
            }
        },
        submitHandler: function () {
           postResQuery();
        }
    });
});
// //submit press
// jQuery(document).ready(function ($) {
//     $("#popup_form").submit(function (even) {
//         even.preventDefault();
//         postResQuery();
//     });
// });
function postResQuery(){
    var formData = {};
    formData["nameResource"] = $("#name_resource").val();
    formData["login"] = $("#login_resource").val();
    formData["password"] = $("#password_resource").val();
    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/addresource",
        data : JSON.stringify(formData),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            display(data);
            popup_hide();
        },
        error : function(e) {
            //  console.log("ERROR: ", e);
            display(e);
        },
        done : function(e) {
            console.log("DONE");
        }
    });
    return false;
}
function display(data) {
    var json = "<h4>Ajax Response</h4><pre>" +JSON.stringify(data, null, 4) +"</pre>";
    $('#feedback').html(json);
}