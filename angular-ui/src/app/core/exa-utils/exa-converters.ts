export function dateToString(date: Date): string{
  if(null == date)
    return null;
  const fullMonth = date.getMonth() < 10 ? `0${date.getMonth()}` : `${date.getMonth()}`;
  const fullDate = date.getDate() < 10 ? `0${date.getDate()}` : `${date.getDate()}`;
  const fullHour = date.getHours() < 10 ? `0${date.getHours()}` : `${date.getHours()}`;
  const fullMinute = date.getMinutes() < 10 ? `0${date.getMinutes()}` : `${date.getMinutes()}`;
  const fullSecond = date.getSeconds() < 10 ? `0${date.getSeconds()}` : `${date.getSeconds()}`;
  return `${date.getFullYear()}-${fullMonth}-${fullDate}T${fullHour}:${fullMinute}:${fullSecond}`;
}
