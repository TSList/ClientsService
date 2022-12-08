// pure js

document.addEventListener('DOMContentLoaded',()=>{
  document.getElementById('submitAddClientForm').onclick = (event) =>{
    event.preventDefault();
    ajaxSubmitForm();
  }
})

const ajaxSubmitForm = () => {
  let form = document.getElementById('addClientForm');
  let formData = new FormData(form);
  let json = JSON.stringify(Object.fromEntries(formData));
  //
  let request = new XMLHttpRequest();
  request.open('post','/rest/addClientForm')
  request.setRequestHeader('Content-Type','application/json; charset=utf-8');
  request.send(json);
  request.addEventListener('readystatechange', ()=>{
    if(request.readyState !==4)
      return
    if (request.status === 200){
      let clients = JSON.parse(request.responseText);
      clients = {'clients':clients}
    }

  })
}