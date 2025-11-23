const goToList = document.querySelector("#goToList");
const updateMemo = document.querySelector("#updateMemo");
const deleteMemo = document.querySelector("#deleteMemo");

goToList.addEventListener("click", () => {

  location.href = "/";

});

const memoNo = new URLSearchParams(location.search).get("memoNo");

updateMemo.addEventListener("click", () => {

  location.href = "/memo/update?memoNo=" + memoNo;

});

deleteMemo.addEventListener("click", () => {

  if(!confirm("정말 삭제하시겠습니까?")) {

    return;

  }

  location.href = "/memo/delete?memoNo=" + memoNo;

})