//document.querySelectorAll('script[type="text/lamb"]').textContent

function interpret(input){
    if(/[a-zA-Z][0-9a-zA-Z]*(\s)?:(\s)?(")?[0-9a-zA-Z]*(")?/.test(input)){
        var name = input.split(":")[0].replace(/\s+/, "");
        var value = input.split(":")[1];
        input = "var " + name + " = " + value;
    }
    //λx.x
    else if(/[a-zA-Z][0-9a-zA-Z]*:(λ[a-zA-Z](.)?)+(?s).*/.test(input)){
        var name = input.split(":")[0];
        var index = input.split(":")[1].lastIndexOf("λ");
        var code = input.split(":")[1].substr(index+1);
        var variables = input.split(":")[1].replace(code, "").replace("λ", "").split(".").join();
        input = "var " + name + " = function(" + variables + "){" + code + "};";
    }
    return eval(input);
}
