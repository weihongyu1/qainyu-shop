/**
 * 时间格式化
 * yyyy-MM-dd
 * @param date
 * @returns {string}
 */
export function dateFormat(date) {
  return date.getFullYear + '-' + date.getMonth + 1 + '-' + date.getDate
}
