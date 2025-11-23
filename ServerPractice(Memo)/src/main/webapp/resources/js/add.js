const memoForm = document.querySelector(".memo-form");
const title = document.querySelector("[name='title']");

memoForm.addEventListener("submit", (e) => {

  const input = title.value.trim();

  if(input.length == 0) {

    e.preventDefault();
    alert("제목을 입력해주세요");
    title.focus();
  }

});