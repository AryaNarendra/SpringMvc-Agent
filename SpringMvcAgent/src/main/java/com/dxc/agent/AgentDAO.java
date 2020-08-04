package com.dxc.agent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class AgentDAO {

	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<Agent> getAgents() {
		return template.query("SELECT * FROM AGENT",new RowMapper<Agent>(){

			@Override
			public Agent mapRow(ResultSet rs, int rowNum) throws SQLException {
				Agent a=new Agent();
				a.setAgentId(rs.getInt("agentId"));
				a.setName(rs.getString("name"));
				a.setCity(rs.getString("city"));
				a.setGender(rs.getString("gender"));
				a.setMaritalStatus(rs.getInt("maritalStatus"));
				a.setAnnualPremium(rs.getDouble("annualPremium"));
				return a;
			}
			});
	}

	public Agent searchByAgentId(int agentId) {
		String sql="SELECT * FROM AGENT WHERE AgentID=?";
		return template.queryForObject(sql, new Object[] {agentId}, new BeanPropertyRowMapper<Agent>(Agent.class));
	}

	public int update(Agent ag) {
		String sql ="Update Agent SET Name=?,City=?,Gender=?,MaritalStatus=?,AnnualPremium=? WHERE AgentID=?";
		return template.update(sql, new Object[] {ag.getName(), ag.getCity(), ag.getGender(), 
				ag.getMaritalStatus(), ag.getAnnualPremium(), ag.getAgentId()});
	}

	public int delete(int agentId) {
		String sql = "DELETE FROM AGENT WHERE AgentID=?";
		return template.update(sql, new Object[] {agentId});
		
	}
	
	public int insert(Agent agent) {
		String cmd ="INSERT INTO AGENT(AgentId,Name,City,Gender,MaritalStatus,AnnualPremium)" + "values(?,?,?,?,?,?)";
		return template.update(cmd, new Object[] {
					agent.getAgentId(),
					agent.getName(),
					agent.getCity(),
					agent.getGender(),
					agent.getMaritalStatus(),
					agent.getAnnualPremium()});
	}
	
}
