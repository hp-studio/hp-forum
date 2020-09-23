import Vue from 'vue';

let vue = new Vue();
export default {
    alert: (option) => {
        const title = option.title || '提示';
        const content = `<div>${option.content || ''}</div>`;
        switch (option.type || 'info') {
            case 'info':
                vue.$Modal.info({
                    title: title,
                    content: content
                });
                break;
            case 'success':
                vue.$Modal.success({
                    title: title,
                    content: content
                });
                break;
            case 'warning':
                vue.$Modal.warning({
                    title: title,
                    content: content
                });
                break;
            case 'error':
                vue.$Modal.error({
                    title: title,
                    content: content
                });
                break;
        }
    }
};
