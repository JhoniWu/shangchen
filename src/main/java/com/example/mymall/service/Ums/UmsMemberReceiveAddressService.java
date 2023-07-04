package com.example.mymall.service.Ums;

import com.example.mymall.mbg.model.UmsMemberReceiveAddress;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-27 15:33
 **/

public interface UmsMemberReceiveAddressService {
	int add(UmsMemberReceiveAddress address);

	int delete(Long id);

	@Transactional
	int update(Long id, UmsMemberReceiveAddress address);

	List<UmsMemberReceiveAddress> list();

	UmsMemberReceiveAddress getItem(Long id);
}
