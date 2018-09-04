export class ServiceName {
  id: number;
  icon: string;
  name: string;
  detail: string;
  path: string;
  status: boolean;
  constructor(id, icon, name, detail, path, status) {
        this.id = id;
        this.icon = icon;
        this.name = name;
        this.detail = detail;
        this.path = path;
        this.status = status;
    }
}
