package com.example.ncovback.service;

import com.example.ncovback.common.AdminR;
import com.example.ncovback.entity.Admin;
import com.example.ncovback.entity.Menu;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MenuService {
    public AdminR getMenu(Admin admin) {
        AdminR r = new AdminR();
        r.setCode(200);
        List<Menu> menuList = new ArrayList<>();
        Menu home = new Menu("/home", "home", "首页", "s-home", "home/index");
        Menu datamanage = new Menu();
        Menu analysis=new Menu();
        Menu releaseinfo=new Menu();
        Menu service=new Menu();
        List<Menu> child_data = new ArrayList<>();
        Menu nCov_data = new Menu("/nCov_data", "nCov_data", "疫情数据", "office-building", "datamanage/nCov_data");
        Menu nCov_test = new Menu("/nCov_test", "nCov_test", "核酸点信息", "notebook-1", "datamanage/nCov_test");
        Menu nCov_yimiao = new Menu("/nCov_yimiao", "nCov_yimiao", "疫苗点信息", "notebook-1", "datamanage/nCov_yimiao");
        Menu nCov_member = new Menu("/nCov_member", "nCov_member", "系统人员", "notebook-1", "datamanage/nCov_member");
        Menu nCov_policy = new Menu("/nCov_policy", "nCov_policy", "防疫政策", "notebook-1", "datamanage/nCov_policy");
        child_data.add(nCov_data);
        child_data.add(nCov_test);
        child_data.add(nCov_yimiao);
        child_data.add(nCov_member);
        child_data.add(nCov_policy);
        datamanage.setLabel("信息维护");
        datamanage.setIcon("location");
        datamanage.setChildren(child_data);
        List<Menu> child_analysis = new ArrayList<>();
        Menu ana_people = new Menu("/ana_people", "ana_people", "人口流动", "office-building", "analysis/ana_people");
        Menu ana_test = new Menu("/ana_test", "ana_test", "核酸检测", "notebook-1", "analysis/ana_test");
        child_analysis.add(ana_people);
        child_analysis.add(ana_test);
        analysis.setLabel("统计分析");
        analysis.setIcon("location");
        analysis.setChildren(child_analysis);
        List<Menu> child_releaseinfo = new ArrayList<>();
        Menu rel_knowledge = new Menu("/rel_knowledge", "rel_knowledge", "防疫知识", "office-building", "releaseinfo/rel_knowledge");
        Menu rel_area = new Menu("/rel_area", "rel_area", "新增风险地区", "notebook-1", "releaseinfo/rel_area");
        Menu rel_allTest = new Menu("/rel_allTest", "rel_allTest", "全员核酸通知", "office-building", "releaseinfo/rel_allTest");
        child_releaseinfo.add(rel_knowledge);
        child_releaseinfo.add(rel_area);
        child_releaseinfo.add(rel_allTest);
        releaseinfo.setLabel("信息发布");
        releaseinfo.setIcon("location");
        releaseinfo.setChildren(child_releaseinfo);
        List<Menu> child_service = new ArrayList<>();
        Menu serv_appeal = new Menu("/serv_appeal", "serv_appeal", "健康码申诉", "office-building", "service/serv_appeal");
        Menu serv_consult = new Menu("/serv_consult", "serv_consult", "健康咨询", "notebook-1", "service/serv_consult");
        child_service.add(serv_appeal);
        child_service.add(serv_consult);
        service.setLabel("客服");
        service.setIcon("location");
        service.setChildren(child_service);
        menuList.add(home);
        menuList.add(datamanage);
        menuList.add(analysis);
        menuList.add(releaseinfo);
        menuList.add(service);
        r.setToken(3333);
        r.setMenu(menuList);
        return r;
    }
}
