
function foo(){
	var Parola1=document.getElementById("Parola1").value;
	var Parola2=document.getElementById("Parola2").value;
	var totale="";
	for(var i=2;i<13;i++){
		if(i!=3)
			totale+=i+"-"+Parola1+"."+Parola2+"<br>";
	}
	document.getElementById("p").innerHTML+=totale;
}
