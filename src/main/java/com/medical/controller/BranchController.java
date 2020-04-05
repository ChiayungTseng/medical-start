package com.medical.controller;

import com.medical.entity.Branch;
import com.medical.mapper.BranchMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {
    @Resource
    private BranchMapper branchMapper;

    @RequestMapping("/query")
    public List<Branch> query(){
        List<Branch> select = branchMapper.select();
        return select;
    }

    @RequestMapping("querybname")
    public List<Branch> querybname(){
        List<Branch> querybname = branchMapper.querybname();
        return querybname;
    }

    @RequestMapping("/add")
    public String add(@RequestBody Branch branch){
        Branch branch1 = branchMapper.selectByBid(branch.getBid());
        if (branch1 != null){
            return "此分店已存在";
        }else {
            branchMapper.save(branch);
            return "branch";
        }
    }
    @RequestMapping("/update")
    public Integer update(@RequestBody Branch branch){
        int row = 0;
        int updateRow = branchMapper.update(branch);
        row = row + updateRow;
        return row;

    }

    @RequestMapping("/delete")
    public  Integer delete(@RequestBody Branch[] branches){
        int row = 0 ;
        for (Branch branch:branches){
            int deleteRow = branchMapper.delete(branch);
            row = row + deleteRow;
        }
        return row;
    }


}
