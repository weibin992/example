import {Message} from 'element-ui';

const util = {
    isEmpty(val) {
        return (val === null || val === undefined || val === '')
    },
    isNotEmpty(val) {
        return !this.isNotEmpty(val)
    },
    alert(message) {
        Message.error({message})
    }
}

export default util;