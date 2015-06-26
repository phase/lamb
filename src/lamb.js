//document.querySelectorAll('script[type="text/lamb"]').textContent
$('input#LambRun').click(function() {
    var text = $('textarea#LambCode').val();
    $('textarea#LambResult').append(eval(text));
});
