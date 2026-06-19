function common() {
  // テーブル行追加
  window.addRow = function(query) {
    const table = document.querySelector(query);
    if (!table && table.tagName != "TABLE") {
      console.error(`${elm}: table is not found`);
      return;
    }
    table.insertRow();
  }
  
  // テーブル行削除
  window.deleteRow = function(elm) {
    const row = elm.closest("tr");
    if (!row) {
      console.error(`${elm}: row is not found`);
      return;
    }
    table.body[0].rows.remove(row);
  }
}

export default common;