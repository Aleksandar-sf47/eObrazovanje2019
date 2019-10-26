import { Deserializable } from './interface/deserializable';
import { Korisnik } from './korisnik';

export class Nastavnik implements Deserializable {

    private id : number;
    private ime : string;
    private prezime : string;
    private jmbg : number;
    private email : string;
    private telefon : number;
    private korisnik : Korisnik;

    deserializable(input : any){
        Object.assign(this, input);
        this.korisnik = new Korisnik().deserializable(input.korisnikDTO);
        return this;
    }

    getId() : number{
        return this.id;
    }

    getIme() : string{
        return this.ime;
    }

    getPrezime() : string{
        return this.prezime;
    }

    getJMBG() : number{
        return this.jmbg;
    }

    getEmail(): string {
        return this.email;
    }

    getTelefon() : number{
        return this.telefon;
    }

    getKorisnik() : Korisnik{
        return this.korisnik;
    }
}
