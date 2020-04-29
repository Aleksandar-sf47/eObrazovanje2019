import { Deserializable } from "./interface/deserializable";
import { Korisnik } from "./korisnik";

export class Nastavnik implements Deserializable {
  public id: number;
  public ime: string;
  public prezime: string;
  public jmbg: number;
  public email: string;
  public telefon: number;
  public korisnik: Korisnik;

  deserializable(input: any) {
    Object.assign(this, input);
    this.korisnik = new Korisnik().deserializable(input.korisnikDTO);
    return this;
  }

  getId(): number {
    return this.id;
  }

  getIme(): string {
    return this.ime;
  }

  getPrezime(): string {
    return this.prezime;
  }

  getJMBG(): number {
    return this.jmbg;
  }

  getEmail(): string {
    return this.email;
  }

  getTelefon(): number {
    return this.telefon;
  }

  getKorisnik(): Korisnik {
    return this.korisnik;
  }
}
