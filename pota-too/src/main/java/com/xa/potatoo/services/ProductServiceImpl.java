package com.xa.potatoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xa.potatoo.model.dto.ProductDto;
import com.xa.potatoo.models.Product;
import com.xa.potatoo.models.Variant;
import com.xa.potatoo.repository.ProductRepo;

@Service
@Transactional

public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepo prodRepo;

	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return prodRepo.findAll();
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return prodRepo.save(product);
	}

	@Override
	public void delete(Long produtId) {
		// TODO Auto-generated method stub
		prodRepo.deleteById(produtId);
	}

	@Override
	public List<ProductDto> queryProduct(Integer pageNo, Integer PageSize, String SortBy, String SortType) {
		// TODO Auto-generated method stub
		Pageable pageable = null;
		if(SortType.equalsIgnoreCase("desc")) {
			pageable = PageRequest.of(pageNo, PageSize,Sort.by(SortBy).descending());
		}else {
			pageable = PageRequest.of(pageNo, PageSize, Sort.by(SortBy).ascending());
		}
		Page<ProductDto> pageResult = prodRepo.fetchProductVariant(pageable);
		
		return pageResult.getContent();
	}

	@Override
	public List<ProductDto> searchProductBy(Integer pageNo, Integer pageSize, String sortBy, String sortType, String name, String description) {
		// TODO Auto-generated method stub
		Pageable pageable = null;
		if(sortType.equalsIgnoreCase("desc")) {
			pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
		}else {
			pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
		}
		
		Page<ProductDto> pageResult = prodRepo.searchProductBy(pageable, name, description);
		
		return pageResult.getContent();
	}

	@Override
	public Product saveProductDto(ProductDto productDto) {
		// TODO Auto-generated method stub
		ProductDto prod = productDto;
		Variant varn = new Variant(prod.getVarnId(),null,null,false,null);
		Product product = new Product(prod.getProductId(),prod.getName(),prod.getDescription(),
				prod.getStock(),prod.getPrice(),prod.isActive(),varn);
		
		return prodRepo.save(product);
	}

	@Override
	public ProductDto findProductById(Long id) {
		// TODO Auto-generated method stub
		return prodRepo.findProductById(id);
	}

	@Override
	public int setProductIsDelete(Long id) {
		// TODO Auto-generated method stub
		return prodRepo.setProductIsDelete(id);
	}
	
	

}
