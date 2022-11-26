import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
	providedIn: 'root'
})
export class OportunidadeService {

	apiUrl = 'http://localhost:8080/oportunidades';

	constructor(private httpClient: HttpClient) { }

	public listar() {
		return this.httpClient.get(this.apiUrl);
	}

	public adicionar(oportunidade: any) {
		return this.httpClient.post(this.apiUrl, oportunidade);
	}

	public alterar(oportunidade: any) {
		return this.httpClient.put(this.apiUrl, oportunidade);
	}

	public remover(id: number) {
		return this.httpClient.delete(this.apiUrl + "/" + id);
	}
}
