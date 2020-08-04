package com.dxc.agent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/agent")
@Controller
public class AgentController {

	@Autowired
	AgentDAO dao;
	
	@RequestMapping("/viewAgent")
	public String showAgent(Model m) {
		List<Agent> list=dao.getAgents();
		m.addAttribute("list", list);
		return "show-agent";
		}
	
	@RequestMapping("/editAgent/{agentId}")
	public String editAgent(@PathVariable int agentId, Model m) {
		Agent result = dao.searchByAgentId(agentId);
		m.addAttribute("command",result);
		return "edit-agent";
	}
	
	@RequestMapping("/editsave")
	public String editData(@ModelAttribute("ag") Agent ag, Model m) {
		int res = dao.update(ag);
		List<Agent> list=dao.getAgents();  
        m.addAttribute("list",list);
		return "show-agent";
	}
	 @RequestMapping("/deleteAgent/{id}")  
	    public String delete(@PathVariable int id, Model m){  
	        dao.delete(id);  
	        List<Agent> list=dao.getAgents();  
	        m.addAttribute("list",list);
			return "show-agent";
	    }   
	 
	 @RequestMapping("/agentForm")
		public String addAgent(Model m) {
			m.addAttribute("command", new Agent());
			return "add-agent";
	 }
	 
	 @RequestMapping("/saveAgent") 
		public String saveData(@ModelAttribute("ag") Agent ag, Model m) {
			dao.insert(ag);
			List<Agent> list=dao.getAgents();  
	        m.addAttribute("list",list);
			return "show-agent";
		}
}
