const myNumbers = [20, 30, 45, 66, 88, 22];
let sum=0;
for(let i=0; i<myNumbers.length;i++){
	console.log(myNumbers[i]);
	sum+=myNumbers[i];
}
sum=0;
for(let num of myNumbers){
	sum += num;
}
sum=0;
myNumbers.forEach(function (elem, idx){
	console.log(`index: ${idx}, value: ${elem}`)
	sum+= elem;
});
console.log(`배열의 누적합: ${sum}`)

let fruits =['Apple','Banana','Cherry']
//document.queryselector('.fruits').innerHTML='';
fruits.forEach(function(elem, idx){
	li = document.createElement('li'); // <li></li>
	txt = document.createTextNode(elem); //reading
	li.appendChild(txt); // <li>reading</li>
	let btn= document.createElement('button');
//	txt=document.createTextNode('삭제');
//	btn.appendChild(txt);
	btn.onclick = function (){
		console.log(btn);
		btn.parentElement.remove(); //li요소 전부 삭제
	}
	btn.innerText = '삭제';
	li.appendChild(btn);
	document.querySelector('.fruits').appendChild(li);
})
