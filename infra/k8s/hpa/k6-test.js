import http from 'k6/http';
import { sleep } from 'k6';

export let options = {
    vus: 300, // 300 usuários virtuais
    duration: '1m', // 30 segundos de duração do teste
    rps: 3000 // 3000 solicitações por segundo
};

export default function () {
    http.get('http://localhost:8080/v1/produto/LANCHE');
    sleep(1);
}