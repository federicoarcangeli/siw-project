# Da Peppe Restaurant

Il <strong>manuale del sito</strong> dove viene illustrato il funzionamento si trova in <code>ManualeSitoDaPeppe/index.html</code>.<br>
Per la <strong>struttura e il popolamento del database</strong> consultare <code>database.txt</code><br>
I <strong>Casi D'uso</strong> è possibile visionarli oltre che qui di seguito anche all'interno del file <code>Casi d'uso.txt</code><br>
Il file di <strong>configurazione di tomee</strong> per accedere al server di amazon si trova all'interno del file <code>tomee.xml</code><br>

#CASI D'USO

* Caso d'uso UC1: consultazione menu 
	- Attore primario: utente non registrato
	- Scenario principale di successo:
		+ l'utente non registrato consulta il menù del ristorante, suddiviso per categorie. Ciascun piatto ha associata una descrizione ed un prezzo

* Caso d'uso UC2: registrazione
	- Attore primario: utente non registrato
	- Scenario principale di successo:
		+ l'utente compila una form immettendo i propri dati e si registra al sito. Viene poi reindirizzato alla home page. Successivamente riceve una mail di conferma di avvenuta registrazione.
	- Estensioni dello scenario principale:
		+ l'utente non immette correttamente i dati come richiesto, e viene mostrato un messaggio di errore specifico

* Caso d'uso UC3: login utente
	- Attore primario: utente registrato, di qualsiasi ruolo
	- Scenario principale di successo:
		+ l'utente immette le proprie credenziali ed effettua l'accesso al sito; a seconda del ruolo accederà ad un'area riservata diversa. Amministratori ed operatori accedono alle proprie aree attraverso una form di login diversa, raggiungibile solo conoscendo l'url.

* Caso d'uso UC4: prenotazione utente
    - Attore primario: utente registrato
    - Scenario principale di successo:
        + l'utente riserva un tavolo presso il ristorante, inserendo la data, l'ora ed il numero di coperti. Se esiste un tavolo libero che soddisfa le condizioni, il tavolo viene riservato all'utente.
    - Estensioni dello scenario princiaple:
        + Il sistema mostra un messaggio di errore se l'utente intende prenotare in un orario in cui non è possibile riservare tavoli, oppure se effettivamente non ci sono posti disponibili

* Caso d'uso UC5: visualizzazione prenotazioni
	- Attore primario: utente registrato
	- Scenario principale di successo:
		+ l'utente visualizza le prenotazioni che ha effettuato

* Caso d'uso UC6: Visualizzazione sala
	- Attore primario: amministratore ed operatori di sala
	- Scenario principale di successo:
		+ amministratore ed operatori visualizzano i tavoli presenti in sala, con un'indicazione se il tavolo è libero, prenotato oppure se i commensali sono già arrivati. Cliccando su di un tavolo il sistema dà la possibilità di prendere l'ordine al tavolo, e mostra le pietanze già ordinate, se presenti

* Caso d'suo UC7: registrazione operatori
	- Attore primario: amministratore
	- Scenario principale di successo:
		+ l'amministratore inserisce username e password di un nuovo operatore, che questi userà poi per entrare nel sistema al momento del servizio

* Casi d'uso UC8: Ordinazione
	- Attori primari: amministratore ed operatori di sala
	- Scenario principale di successo: 
		+ l'operatore di sala (o l'amministratore) aprono un tavolo dalla pagina di visualizzazione della sala. Viene mostrato il menù offerto dal ristorante e un riepilogo delle pietanza già inserite all'interno della comanda: l'operatore cliccando su di un piatto lo aggiunge alla comanda. Successivamente può variare le quantità, oppure decidere di eliminare la linea dalla comanda
	- Estensioni dello scenario principale:
		+ una volta completato l'ordine, l'amministratore può decidere di stampare la ricevuta oppure di cancellare l'ordine

* Caso d'uso UC9: Inserimento di un piatto
	- Attore primario: amministratore
	- Scenario principale di successo:
		+ l'amministratore sceglie una categoria già presente e inserisce il nome del piatto, una descrizione ed un prezzo; inoltre, se necessario, specifica se il piatto contiene prodotti surgelati oppure allergeni.

* Caso d'uso UC10: prenotazione utente non registrato
	- Attore primario: amministratore
	- Scenario principale di successo:
		+ l'amministratore può prendere una prenotazione da parte di un utente non registrato (che contatta il ristorante), aggiungendone il nominativo.
	- Estensioni dello scenario principale:
		+ l'amministratore può visualizzare tutte le prenotazioni per il giorno corrente, ne può selezionare una e cancellarla.
