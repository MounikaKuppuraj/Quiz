window.addEventListener('load',function(){
var elem=document.getElementsByClassName('nextButton');
	for(var i=0;i<elem.length-1;i++){
		var val =i+1;
		//console.log(val);
		(function(index) {
			elem[i].addEventListener('click',function(){
				//toggle(val);
				console.log(index+1);
				document.getElementById('question'+(index+1)).style="display:none";
				document.getElementById('question'+(index+2)).style="display:block";
			});
		})(i);	
}
});


   