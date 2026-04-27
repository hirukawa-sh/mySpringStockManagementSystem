// 販売管理
function sales() {
  // 一覧グリッド
  const salesGrid = new gridjs.Grid({
    columns: [
      { name: "ID", id: "id", width: "60px", formatter: (cell) => {
          return gridjs.h("a", {
            text: cell,
            href: "#",
            onClick: (e) => {
              e.preventDefault();
              showSalesDetailModal(cell);
            }
          });
        },
      },
      { name: "販売価格", id: "totalPrice", width: "100px" },
      { name: "販売日時", id: "salesDate", width: "100px" }
    ],
    pagination: {
      limit: 10
    },
    sort: true,
    search: true,
    resizable: true,
    server: {
      url: "/api/sales",
      then: data => data.map(sales => [
        sales.id,
        sales.totalPrice,
        sales.salesDate
      ])
    }
  }).render(document.getElementById("grid_sales"));
}

// 明細モーダルを開く
async function showSalesDetailModal(salesId) {
  const detailModalElment = document.getElementById("salesDetail");
  const detailModal = new bootstrap.Modal(detailModalElment);

  try {
    const response = await fetch(`/api/sales/${salesId}`);
    const data = await response.json();

    // 詳細情報をモーダルに表示
    document.getElementById("detail_id").textContent = data.id;
    document.getElementById("detail_salesperson").textContent = data.salesPerson;
    document.getElementById("detail_salesdate").textContent = data.salesDate;

    // 明細グリッド
    const detailItemsGrid = new gridjs.Grid({
      columns: [
        { name: "商品名", id: "itemName", width: "100px" },
        { name: "販売価格", id: "salesPrice", width: "100px" },
        { name: "数量", id: "quantity", width: "80px" }
      ],
      pagination: {
        limit: 10
      },
      sort: true,
      search: true,
      resizable: true,
      server: {
        url: `/api/sales/${salesId}/details`,
        then: data => data.map(detail => [
          detail.id,
          detail.itemName,
          detail.salesPrice,
          detail.quantity
        ])
      }
    }).render(document.getElementById("grid_detail_items"));

    // 小計、税額、合計の表示
    document.getElementById("detail_subtotal").textContent = data.subtotal;
    document.getElementById("detail_tax").textContent = data.tax;
    document.getElementById("detail_total").textContent = data.total;
  } catch (error) {
    console.error("販売詳細の取得に失敗:", error);
  }
  
  detailModal.show();
}

export default sales;