// 商品管理
async function item() {
  var itemData = [];

  // データの取得
  await fetch("/api/items")
    .then(response => response.json())
    .then(data => {
      itemData = data.map(item => [
        item.id,
        item.name,
        item.salesPrice
      ]);
    })
    .catch(error => {
      console.error("Error fetching items:", error);
    });
  
  // 一覧グリッド
  const itemGrid = new gridjs.Grid({
    columns: [
      { name: "ID", id: "id", width: "60px", formatter: (cell) => {
            return gridjs.html(`<a href="items/edit/${cell}">${cell}</a>`);
          }
      },
      { name: "商品名", id: "name", width: "150px" },
      { name: "販売価格", id: "salesPrice", width: "80px" }
    ],
    pagination: {
      limit: 10
    },
    sort: true,
    search: true,
    resizable: true,
    data: itemData
  }).render(document.getElementById("grid_item"));
}

export default item;