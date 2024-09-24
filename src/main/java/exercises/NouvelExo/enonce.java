export interface Bar {
  attr1: number;
  attr2?: string;
}

export class Foo {
  private http: HttpService;
  private errMsg: string | undefined;
  private data: Array<Bar>;

  public foo(): void {
    this.http... //TODO Q1

    console.log(this.data); // Q6
  }

  public foo2(p: string): void {    
    // TODO Q5
  }
}

/* Q1. Soit une route REST 'api/v1/foo/bar' GET qui retourne en JSON une liste d'objets de type Bar.
Donner le code TypeScript/Angular exécutant une telle requête à l'aide de l'attribut `http`.
Vous utiliserez l'API standard Angular pour faire cela à savoir Observable.
Le traitement de la réponse affectera le résultat obtenu à l'attribut data.
Traitez le cas d'une erreur dans la requête en modifiant l'attribut errMsg. */

export interface Bar {
  attr1: number;
  attr2?: string;
}

export class Foo {
  private http: HttpService;
  private errMsg: string | undefined;
  private data: Array<Bar>;

  public foo(): void {
    this.http.get<Array<Bar>>("api/v1/foo/bar").subscribe({
        /* "complete": () => {
        }, */
        "error": (err: unknown) => {
            this.errMsg = "Erreur requête";
        },
        "next": data => {
            this.data = data;
        }
        /* OU   "next": (data:Array<Bar>) => {
                    this.data = data;
                } */
    });

    console.log(this.data); // Q6
  }

  public foo2(p: string): void {    
    // TODO Q5
  }
}
 
 
/* Q2. Changer ensuite le code pour utiliser Promise à l'aide de lastValueFrom(). */
export interface Bar {
  attr1: number;
  attr2?: string;
}

export class Foo {
  private http: HttpService;
  private errMsg: string | undefined;
  private data: Array<Bar>;

  public foo(): Promise<Bar> | undefined{
    return lastValueFrom(this.http.get("api/v1/foo/bar"))
    .then((data:Array<Bar>) => {
        this.data = data;
        return data;
        // ou return data.at(0);
    })
    .catch(err => {
        this.errMsg = "Erreur requête";
    })
    ;

    console.log(this.data); // Q6
  }

  public foo2(p: string): void {    
    // TODO Q5
  }
}
 
 
/* Q3. Pourquoi ne faut-il pas écrire : this.http.get('http://www.mon.service.web/api/foo')...;  ? */

//Ça marche pas car l'URL est hardcodée
//C'est pas l'appli Angular qui doit connaître l'URL mais il doit y avoir un fichier de configuration qui contient l'URL
//On met juste api/foo

// ex config :
// "/api/foo": "http://www.mon.service.web/api/foo"
 
/* Q4. Quelle est la différence entre Observable et Promise ?
Et dans le cas des requêtes REST, dans quel rare cas Observable est pertinent ? */
 
 
/* Q5. Soit une route REST api/v1/foo/yolo/{param} GET qui ne retourne rien.
Donnez le code TypeScript/Angular exécutant une telle requête en utilisant le paramètre p pour le paramètre param. */
 
/* Q6. Qu'affiche la ligne console.log(this.data) ? */
// c'est exécuté avant que la requête soit terminée