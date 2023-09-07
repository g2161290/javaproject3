/**
 * 
 */
console.log('js/reply.js');

class Reply {
	showInfo() {
		console.log('ssssss')
	}
	//목록조회 기능
	replyList(noticeId, callback, errorcall) {
		/*let xhttp = new XMLHttpRequest();
		xhttp.open('get', 'AjaxReplyList.do?nid=' + noticeId);
		xhttp.send();
		xhttp.onload = function(e) {
			console.log(xhttp.responseText);
			let data = JSON.parse(xhttp.responseText);
			console.log(data);
			callback(data);

		}*/
		fetch('AjaxReplyList.do?nid=' + noticeId) //promise: pending(처리중), fulfilled(완료), 실패
		.then(resolve=> resolve.json()) // 문자 -> 객체
		.then(result=>callback(result))
		.catch(err =>errorcall(err))
	}
	//댓글 삭제 기능
	replyRemove(replyId, callback){
		/*let xhttp = new XMLHttpRequest();
		xhttp.open('get', 'AjaxReplyDelete.do?rid=' + replyId);
		xhttp.send();
		xhttp.onload = function(e) {
			let data =JSON.parse(xhttp.responseText);
			callback(data)
			}*/
		fetch('AjaxReplyDelete.do?rid=' + replyId)
		.then(resolve=>resolve.json())
		.then(result=>callback(result))
		.catch(err=>errorcall(err))
	}
	//댓글 등록 기능
	replyAdd(reply={nid:1, replyer:'user1', reply:'test'}, callback){
		/*let xhttp = new XMLHttpRequest();
		xhttp.open('post','AjaxReplyAdd.do');
		xhttp.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
		xhttp.send('nid='+reply.nid+'&content='+reply.reply+'&writer='+reply.replyer);
		xhttp.onload = function(e){
			let data = JSON.parse(xhttp.responseText);
			callback(data);
		}*/
		fetch('AjaxReplyAdd.do',{
			method: "POST",
			headers: {
				'Content-Type':'application/x-www-form-urlencoded',
			},
			body: 'nid='+reply.nid+'&content='+reply.reply+'&writer='+reply.replyer
		})
		.then(resolve=>resolve.json())
		.then(result=>callback(result))
		.catch(console.log);
	}
	replySearch(replyId,callback){
		/*let xhttp = new XMLHttpRequest();
		xhttp.open('get','AjaxReplySearch.do?rid='+replyId);
		xhttp.send();
		xhttp.onload=function (e){
			let data= JSON.parse(xhttp.responseText);
			callback(data)
		}*/
		fetch('AjaxReplySearch.do?rid='+replyId)
		.then(resolve=>resolve.json())
		.then(result=>callback(result))
		.catch(console.log);
	}
	replyModify(reply={rid: 10, reply:"변경값입니다..."}, callback){
		/*let xhttp = new XMLHttpRequest();
		xhttp.open('post','AjaxReplyModify.do')
		xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
		xhttp.send('rid='+reply.rid+'&content='+reply.reply)
		xhttp.onload=function (e){
			let data = JSON.parse(xhttp.responseText);
			callback(data)
		}*/
		fetch('AjaxReplyModify.do',{
			method: "POST",
			headers: {
				'Content-Type':'application/x-www-form-urlencoded',
			},
			body:'rid='+reply.rid+'&content='+reply.reply
		})
		.then(resolve=>resolve.json())
		.then(result=>callback(result))
		.catch(console.log);
	}
	// 숫자 => 년 월 일 시 분 초 출력.
	displayDate(millis) {
		let today = new Date(millis);
		let yyyy = today.getFullYear();
		let mm = ('0' + (today.getMonth() + 1)).slice(-2);
		let dd = ('0' + today.getDate()).slice(-2);
		let hh = ('0' + today.getHours()).slice(-2);
		let mi = ('0' + today.getMinutes()).slice(-2);
		let ss = ('0' + today.getSeconds()).slice(-2);

		return yyyy + "-" + mm + "-" + dd + " " + hh + ":" + mi + ":" + ss;
	}
}