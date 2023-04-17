package com.eoi.Facturacion.repositorios;

import com.eoi.Facturacion.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface InvoiceReposiroty extends JpaRepository<Invoice, Long> {
}
