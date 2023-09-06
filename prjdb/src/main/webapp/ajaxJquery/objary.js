const mem1 = {
	name: "홍길동",
	age: 20,
	phone: '010-1111'
}
const mem2 = {
	name: "김길동",
	age: 23,
	phone: '010-2222'
}
const mem3 = {
	name: "박길동",
	age: 26,
	phone: '010-3333'
}
const members = [mem1, mem2, mem3];
let target = document.querySelector('#memberList>tbody');
members.forEach(addMemberFunction); //배열요소, idx, array

document.querySelector('#memberList>tbody button').onclick = function(e) {
	e.target.parentElement.parentElement.remove();
}

document.querySelector('#memberList>tbody button').setAttribute('style', 'color: red')
document.querySelectorAll('#memberList>tbody>tr').forEach(function(tr) {
	tr.addEventListener('mouseover', function() {
		tr.setAttribute('style', 'background:yellow')
	})
	tr.addEventListener('mouseout', function() {
		tr.setAttribute('style', 'background:null')
	})
})
document.querySelector(".add").addEventListener('click', function() {
	const member = {
		name: document.querySelector('input[name=name]').value,
		age: document.querySelector('input[name=age]').value,
		phone: document.querySelector('input[name=phone]').value
	}
	addMemberFunction(member);
})
function addMemberFunction(member = {}) {
	let tr = document.createElement('tr')
	for (let prop in member) {
		let td = document.createElement('td')
		td.innerText = member[prop];
		tr.appendChild(td);
	}
	let td = document.createElement('td')
	let button = document.createElement('button');
	button.addEventListener('click', function(e) {
		console.log(e) // this
		e.target.parentElement.parentElement.remove(); //e.target==button
	});
	button.innerText = '삭제';
	td.appendChild(button);
	tr.appendChild(td);
	target.appendChild(tr);
}
