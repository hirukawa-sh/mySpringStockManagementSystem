import * as common from './common.js'

// ページの識別子を取得
const page = document.body.dataset.page;

// メイン
async function app() {
    // ページ毎に必要なモジュールを動的にインポート
    switch (page) {
        case "login":
            const login = await import('./login.js');
            await login.default();
            break;

        case "menu":
            const menu = await import('./menu.js');
            await menu.default();
            break;

        case "items":
            const item = await import('./item.js');
            await item.default();
            break;

        case "edititem":
            const edititem = await import('./edititem.js');
            await edititem.default();
            break;

        case "sales":
            const sales = await import('./sales.js');
            await sales.default();
            break;
            
        case "editsales":
            const editsales = await import('./editsales.js');
            await editsales.default();
        break;
        
        case "stock":
            const stock = await import('./stock.js');
            await stock.default();
            break;
    }
}

window.common = common;
console.log(common);

app();