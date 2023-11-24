package de.zettsystems.broker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.STRICT_STUBS;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = STRICT_STUBS) //default, Alternative LENIENT
class BrokerTest {

    @Mock
    private StockService stockService;

    @InjectMocks
    private Broker testee;

    @Captor
    private ArgumentCaptor<Integer> quantityCaptor;

    @Captor
    private ArgumentCaptor<Stock> stockCaptor;


    @Test
    void shouldBuyStocks() {
        when(stockService.getPrice(any(Stock.class))).thenReturn(100.0D);

        testee.buyBestStock(1_000_000);

        verify(stockService).buy(stockCaptor.capture(), quantityCaptor.capture());

        assertThat(quantityCaptor.getValue()).isEqualTo(10_000);
        final Stock value = stockCaptor.getValue();
        assertThat(value.getName()).isEqualTo("SAP");
    }

    @Test
    void shouldBuyStocksInOrder() {
        when(stockService.getPrice(any(Stock.class))).thenReturn(100.0D);

        testee.buyBestStock(1_000_000);

        InOrder inOrder = inOrder(stockService);
        inOrder.verify(stockService).getPrice(any(Stock.class));
        inOrder.verify(stockService).buy(stockCaptor.capture(), quantityCaptor.capture());
        verifyNoMoreInteractions(stockService);

        assertThat(quantityCaptor.getValue()).isEqualTo(10_000);
        final Stock value = stockCaptor.getValue();
        assertThat(value.getName()).isEqualTo("SAP");
    }
}