new gridjs.Grid({
  columns: [
    { name: "ID", id: "id" },
    { name: "商品名", id: "name" },
    { name: "販売価格", id: "salesPrice" }
  ],
  server: {
    url: "/api/items",
    then: data => data.map(order => [
      order.id,
      order.name,
      order.salesPrice
    ])
  }
}).render(document.getElementById("grid_item"));