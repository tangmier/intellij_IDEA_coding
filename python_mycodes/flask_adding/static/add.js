/**
 * Created by vostro on 2015/12/7.
 */
function add()
{
    var add1=Number(document.form1.adder1.value);
    var add2=Number(document.form1.adder2.value);
    //var result=add1+add2;
    //alert(result);
    document.form1.result.value=add1+add2;
}