const submitRegForm = () => {

  let form =  document.forms.namedItem('registrationForm');
  let pass = form.elements.namedItem('password').value
  let confirm = form.elements.namedItem('confirm').value
 if (pass === confirm)
   form.submit()
  else
    alert('mismatch password')

}