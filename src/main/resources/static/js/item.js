// 商品管理
function item() {
  // 一覧グリッド
  const itemGrid = new gridjs.Grid({
    columns: [
      { name: "ID", id: "id", formatter: (cell) => {
            return gridjs.html(`<a href="items/edit/${cell}">${cell}</a>`);
          }
      },
      { name: "商品名", id: "name" },
      { name: "販売価格", id: "salesPrice" }
    ],
    pagination: {
      limit: 10
    },
    sort: true,
    search: true,
    resizable: true,
    server: {
      url: "/api/items",
      then: data => data.map(item => [
        item.id,
        item.name,
        item.salesPrice
      ])
    }
  }).render(document.getElementById("grid_item"));
}

export default item;