// テーブル行追加
function addRow(elm) {
  const table = elm.closest("table");
  if (!table) {
    console.error(`${elm}: table is not found`);
    return;
  }
  table.insertRow();
}

// テーブル行削除
function deleteRow(elm) {
  const row = elm.cosest("tr");
  if (!row) {
    console.error(`${elm}: row is not found`);
    return;
  }
  table.body[0].rows.remove(row);
}

export default *;