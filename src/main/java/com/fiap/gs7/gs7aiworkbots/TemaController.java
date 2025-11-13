package com.fiap.gs7.gs7aiworkbots;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class TemaController {

    @GetMapping("/info")
    public ResponseEntity<Map<String, String>> getInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("tema", "Bots e agentes de IA como parceiros no dia a dia de trabalho");
        info.put("membro1", "Lucas Thomazette Benvenuto");
        info.put("membro2", "Pedro Loterio dos Santos");
        info.put("descricao", "Esta API foi desenvolvida para demonstrar a integração de bots e agentes de IA como parceiros no ambiente de trabalho. A solução visa facilitar a automação de tarefas rotineiras, melhorar a produtividade e proporcionar assistência inteligente no dia a dia profissional.");
        
        return ResponseEntity.ok(info);
    }
}

