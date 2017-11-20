export class UrlHelper{
  public static mapParameters(url: string, parameters?: Map<string, string>) : string {
    if(!parameters)
      return url;
    parameters.forEach((value, key) => {
      url = url.replace(`{${key}}`, value);
    });
    return url;
  }
}
