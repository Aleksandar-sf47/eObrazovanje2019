import { Deserializable } from './interface/deserializable';

export class Korisnik implements Deserializable{
    private id : number;
    private korisnickoIme : string;
    private sifra : string;
    private listaUloga : [];

    deserializable(input : any){
        Object.assign(this, input);
        return this;
    }

    getId():number{
        return this.id;
    }

    getKorisnickoIme() : string{
        return this.korisnickoIme;
    }

    getSifra() : string{
        return this.sifra;
    }

    getListaUloga() : []{
        return this.listaUloga;
    }

    
}
